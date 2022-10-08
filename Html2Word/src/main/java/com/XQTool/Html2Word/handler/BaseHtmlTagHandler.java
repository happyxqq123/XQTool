package com.XQTool.Html2Word.handler;

import com.XQTool.Html2Word.HandlerParams;
import com.deepoove.poi.data.style.Style;

/**
 *
 */
public abstract class BaseHtmlTagHandler {

    public abstract String getMatchTagName();

    public abstract void handleHtmlElement(HandlerParams params, Style style);


}
