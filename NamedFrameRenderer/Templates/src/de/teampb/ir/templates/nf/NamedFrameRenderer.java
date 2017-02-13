package de.teampb.ir.templates.nf;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.context.ResponseWriter;

import oracle.adf.view.rich.component.rich.fragment.RichDeclarativeComponent;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.render.ClientComponent;
import oracle.adf.view.rich.render.RichRenderer;

import oracle.adfinternal.view.faces.renderkit.rich.DeclarativeComponentRenderer;

import org.apache.myfaces.trinidad.bean.FacesBean;
import org.apache.myfaces.trinidad.context.RenderingContext;
import org.apache.myfaces.trinidad.render.CoreRenderer;

import oracle.adfinternal.view.faces.renderkit.rich.PanelGroupLayoutRenderer;

public class NamedFrameRenderer extends PanelGroupLayoutRenderer {
    public NamedFrameRenderer() {
        super();
    }

    private static final String DEFAULT_COLOR = "#AAAAAA";

    private static final String IMPORTANT_COLOR = "#FFAAAA";

    @Override
    protected void encodeAll(FacesContext facesContext, RenderingContext renderingContext, UIComponent uIComponent,
                             ClientComponent clientComponent, FacesBean facesBean) throws IOException {
        ResponseWriter rw = facesContext.getResponseWriter();
        if (uIComponent.getParent() instanceof NamedFrame) {
            NamedFrame nf = (NamedFrame) uIComponent.getParent();
            rw.startElement("div", null);
            rw.writeAttribute("style", "border: 2px solid " + getColor(nf) + "; margin: 5px; padding: 5px", null);
            rw.startElement("h2", null);
            rw.writeAttribute("style",
                              "text-indent: 30px;\n" + "    margin-top: -10px;\n" + "    height: 10px;\n" +
                              "    line-height: 20px;\n" + "    font-size: 15px;", null);
            rw.startElement("span", null);
            rw.writeAttribute("style", "background-color:#FFFFFF; color:#000000;", null);
            rw.writeText(nf.getTitle(), null);
            rw.endElement("span");
            rw.endElement("h2");
            super.encodeAll(facesContext, renderingContext, uIComponent, clientComponent, facesBean);
            rw.endElement("div");
        } else
            super.encodeAll(facesContext, renderingContext, uIComponent, clientComponent, facesBean);
    }

    private String getColor(NamedFrame nf) {
        if ("important".equals(nf.getType())) {
            return IMPORTANT_COLOR;
        } else
            return DEFAULT_COLOR;
    }

}
