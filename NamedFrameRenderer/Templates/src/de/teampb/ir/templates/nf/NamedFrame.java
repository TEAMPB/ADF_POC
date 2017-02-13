package de.teampb.ir.templates.nf;

import oracle.adf.view.rich.component.rich.fragment.RichDeclarativeComponent;

public class NamedFrame extends RichDeclarativeComponent {
    
    static public final String COMPONENT_FAMILY =
      "de.teampb.ir.templates.Components";
    static public final String COMPONENT_TYPE =
      "oracle.adf.Include";
    
    public NamedFrame() {
        super("de.teampb.ir.templates.nf.NamedFrame");
    }
    
    public String getTitle() {
        return (String)this.getAttributes().get("title");
    }
    
    public String getType() {
        return (String)this.getAttributes().get("type");
    }


    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }
}
