package it.naturtalent.technik.renderer;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.ecp.view.internal.table.swt.MessageKeys;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.renderer.NoPropertyDescriptorFoundExeption;
import org.eclipse.emf.ecp.view.spi.renderer.NoRendererFoundException;
import org.eclipse.emf.ecp.view.spi.table.model.VTableControl;
import org.eclipse.emf.ecp.view.spi.table.swt.TableControlDetailDialogSWTRenderer;
import org.eclipse.emf.ecp.view.spi.table.swt.TableControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.util.swt.ImageRegistryService;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.databinding.emf.EMFFormsDatabindingEMF;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.localization.LocalizationServiceHelper;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;


/**
 * Validation Spalte ausblenden
 * Spalteneditor der Tabelle abschalten
 * 
 * @author dieter
 *
 */
public class SocketGroupTableRenderer extends TableControlDetailDialogSWTRenderer
{

	@Inject
	public SocketGroupTableRenderer(VTableControl vElement,
			ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding,
			EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider,
			ImageRegistryService imageRegistryService,
			EMFFormsEditSupport emfFormsEditSupport)
	{
		super(vElement, viewContext, reportService, (EMFFormsDatabindingEMF) emfFormsDatabinding,
				emfFormsLabelProvider, vtViewTemplateProvider, imageRegistryService,
				emfFormsEditSupport);
	}

	@Override
	protected Control renderControl(SWTGridCell gridCell, Composite parent)
			throws NoRendererFoundException, NoPropertyDescriptorFoundExeption
	{
		Control control = super.renderControl(gridCell, parent);
		
		TableColumn[] columns = ((TableViewer)getTableViewer()).getTable().getColumns();

		// Validation-Column entfernen
		columns[0].dispose();
				
		// Celleditorsupport zuruecksetzen
		TableViewerColumn[]tableViewerColumns = getTableViewerColumns((TableViewer)getTableViewer());
		for(TableViewerColumn tableViewerColumn : tableViewerColumns)	
			tableViewerColumn.setEditingSupport(null);
		
		return control;
	}

	/*
	 * Die Tabellenspalten in einem Array zusammenfassen
	 */
	private TableViewerColumn[] getTableViewerColumns(TableViewer tableViewer)
	{
		TableColumn[] columns = tableViewer.getTable().getColumns();
		TableViewerColumn[] viewerColumns = new TableViewerColumn[columns.length];
		for (int i = 0; i < columns.length; i++)
		{
			TableColumn tableColumn = columns[i];
			viewerColumns[i] = (TableViewerColumn) tableColumn
					.getData(Policy.JFACE + ".columnViewer"); //$NON-NLS-1$
		}
		return viewerColumns;
	}


	
	
	
	
}
