package it.naturtalent.technik.services;

import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emf.ecp.view.treemasterdetail.model.VTreeMasterDetail;
import org.eclipse.emf.ecp.view.treemasterdetail.ui.swt.internal.TreeMasterDetailSWTRendererService;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;

import it.naturtalent.technik.renderer.SocketMasterDetailRenderer;

public class SocketMasterDetailRendererService extends TreeMasterDetailSWTRendererService
{

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService#isApplicable(org.eclipse.emf.ecp.view.spi.model.VElement,
	 *      org.eclipse.emf.ecp.view.spi.context.ViewModelContext)
	 */
	@Override
	public double isApplicable(VElement vElement, ViewModelContext viewModelContext) {
		if (VTreeMasterDetail.class.isInstance(vElement)) {
			return 10d;
		}
		return NOT_APPLICABLE;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService#getRendererClass()
	 */
	@Override
	public Class<? extends AbstractSWTRenderer<VTreeMasterDetail>> getRendererClass() {
		return SocketMasterDetailRenderer.class;
	}

}
