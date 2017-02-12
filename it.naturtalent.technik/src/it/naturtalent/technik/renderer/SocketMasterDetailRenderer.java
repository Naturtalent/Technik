package it.naturtalent.technik.renderer;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.internal.workbench.swt.E4Application;
import org.eclipse.e4.ui.services.EContextService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.treemasterdetail.ui.swt.TreeMasterDetailSWTRenderer;
import org.eclipse.emf.ecp.view.treemasterdetail.model.VTreeMasterDetail;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.swt.core.EMFFormsControlProcessorService;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsContextProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.contexts.ContextService;

import it.naturtalent.technik.TechnikAddon;

/**
 * Dieser Renderer wird benoetigt, um ueber den Zugriff auf den TreeViewer das im Master selektierte Object
 * ueber den SelectionService bekannt zu machen.
 * 
 * @author dieter
 *
 */
public class SocketMasterDetailRenderer extends TreeMasterDetailSWTRenderer
{

	private class TreeMasterViewSelectionListener implements ISelectionChangedListener
	{
		@Override
		public void selectionChanged(SelectionChangedEvent event)
		{
			final Object treeSelected = ((IStructuredSelection) event.getSelection()).getFirstElement();			
			if (treeSelected instanceof EObject) 
			{
				selectionService.setSelection(treeSelected);				
			}
		}
	}

	private TreeViewer treeViewer;
	
	
	private ESelectionService selectionService  = TechnikAddon.getSelectionService();
	
	
	
	@Inject
	public SocketMasterDetailRenderer(VTreeMasterDetail vElement,
			ViewModelContext viewContext, ReportService reportService)
	{
		super(vElement, viewContext, reportService);
	}

	@Override
	protected TreeViewer createMasterTree(Composite masterPanel)
	{
		treeViewer = super.createMasterTree(masterPanel);
		
		treeViewer.addSelectionChangedListener(new TreeMasterViewSelectionListener());
		
		return treeViewer;
	}



}
