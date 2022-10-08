package com.XQTool.Html2Word;

import com.deepoove.poi.xwpf.NiceXWPFDocument;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.xmlbeans.XmlCursor;
import org.jsoup.nodes.Node;

/**
 * @ClassName HandlerParams
 * @Description TODO
 * @Author xqq
 * @Date 2022/10/8 15:22
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
public class HandlerParams {
    /**
     * current html node
     */
    private Node currentNode;

    /**
     * current word paragraph
     */
    private XWPFParagraph currentParagraph;

    /**
     * current run
     */
    private XWPFRun currentRun;

    /**
     * document object
     */
    private NiceXWPFDocument doc;

    /**
     * whether to iterate child node
     */
    private Boolean continueItr = true;

    /**
     * other function
     */
    private Object extendedParams;

    /**
     * whether to break;
     */
    private boolean enableBreak = true;

    public XWPFRun createRun(){
        this.currentRun = this.getCurrentParagraph().createRun();
        this.enableBreak = true;
        return this.currentRun;
    }

    public XWPFParagraph insertNewParagraph(IBodyElement bodyElement){
        if(bodyElement == null){
            bodyElement = this.currentParagraph;
        }
        int pos = bodyElement.getBody().getBodyElements().indexOf(bodyElement);
        XmlCursor xmlCursor = null;
        if ((pos + 1) >= bodyElement.getBody().getBodyElements().size()) {
            this.currentParagraph = this.doc.createParagraph();
        } else {
            IBodyElement next = bodyElement.getBody().getBodyElements().get(pos + 1);

            if (next instanceof XWPFTableCell) {
                xmlCursor = ((XWPFTableCell) next).getCTTc().newCursor();
            } else if (next instanceof XWPFParagraph) {
                xmlCursor = ((XWPFParagraph) next).getCTP().newCursor();
            }
            this.currentParagraph = bodyElement.getBody().insertNewParagraph(xmlCursor);
        }
        this.createRun();
        this.enableBreak = false;
        return this.currentParagraph;
    }

    public XWPFParagraph insertNewParagraph(){
        return insertNewParagraph(null);
    }




}
