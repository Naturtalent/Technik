package it.naturtalent.technik;

import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.jobs.ProgressProvider;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;

public class ProgressMonitorControl
{
	private final UISynchronize sync;

	private ProgressBar progressBar;

	private GobalProgressMonitor monitor;

	@Inject
	public ProgressMonitorControl(UISynchronize sync)
	{
		this.sync = Objects.requireNonNull(sync);
	}

	@PostConstruct
	public void createControls(Composite parent)
	{
		progressBar = new ProgressBar(parent, SWT.SMOOTH);
		progressBar.setBounds(100, 10, 200, 20);

		monitor = new GobalProgressMonitor();

		Job.getJobManager().setProgressProvider(new ProgressProvider()
		{
			@Override
			public IProgressMonitor createMonitor(Job job)
			{
				return monitor.addJob(job);
			}
		});
	}

	// IProgressMonitor
	private final class GobalProgressMonitor extends NullProgressMonitor
	{

		// thread-Safe via thread confinement of the UI-Thread
		// (means access only via UI-Thread)
		private long runningTasks = 0L; // Anzahl der laufenden Tasks

		
		/**
		 * Notifies that the main task is beginning.  This must only be called once
		 * on a given progress monitor instance.
		 * 
		 * @param name the name (or description) of the main task
		 * @param totalWork the total number of work units into which
		 *  the main task is been subdivided. If the value is <code>UNKNOWN</code> 
		 *  the implementation is free to indicate progress in a way which 
		 *  doesn't require the total number of work units in advance.
		 */
		
		@Override
		public void beginTask(final String name, final int totalWork)
		{
			sync.syncExec(new Runnable()
			{

				@Override
				public void run()
				{
					if (runningTasks <= 0)
					{
						// --- no task is running at the moment ---
						progressBar.setSelection(0);
						progressBar.setMaximum(totalWork);

					}
					else
					{
						// --- other tasks are running ---
						progressBar.setMaximum(
								progressBar.getMaximum() + totalWork);
					}

					runningTasks++;
					progressBar.setToolTipText("Currently running: "
							+ runningTasks + "\nLast task: " + name);
				}
			});
		}

		/**
		 * Notifies that a given number of work unit of the main task
		 * has been completed. Note that this amount represents an
		 * installment, as opposed to a cumulative amount of work done
		 * to date.
		 *
		 * @param work a non-negative number of work units just completed
		 */
		
		@Override
		public void worked(final int work)
		{
			sync.syncExec(new Runnable()
			{

				@Override
				public void run()
				{
					// ProgressBar schreitet um einen weiteren Teil (work) weiter
					progressBar.setSelection(progressBar.getSelection() + work);
				}
			});
		}

		public IProgressMonitor addJob(Job job)
		{
			if (job != null)
			{
				job.addJobChangeListener(new JobChangeAdapter()
				{
					/**
					 * Notifies that the work is done; that is, either the main task is completed 
					 * or the user canceled it. This method may be called more than once 
					 * (implementations should be prepared to handle this case).
					 */
					
					@Override
					public void done(IJobChangeEvent event)
					{
						sync.syncExec(new Runnable()
						{

							@Override
							public void run()
							{
								runningTasks--;
								if (runningTasks > 0)
								{
									// --- some tasks are still running ---
									progressBar.setToolTipText(
											"Currently running: "
													+ runningTasks);

								}
								else
								{
									// --- all tasks are done (a reset of
									// selection could also be done) ---
									progressBar.setToolTipText(
											"No background progress running.");
								}
							}
						});

						// clean-up
						event.getJob().removeJobChangeListener(this);
					}
				});
			}
			return this;
		}
	}

}
