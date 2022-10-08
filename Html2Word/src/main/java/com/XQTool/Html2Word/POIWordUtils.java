package com.XQTool.Html2Word;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

/**
 * @ClassName POIWordUtils
 * @Description TODO
 * @Author xqq
 * @Date 2022/10/8 15:40
 * @Version 1.0
 **/
public class POIWordUtils {

    public static void setVMMergRestart(XWPFTableCell tableCell){
        if (tableCell.getCTTc().getTcPr() == null) {
            tableCell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
        } else {
            if (tableCell.getCTTc().getTcPr().getVMerge() == null) {
                tableCell.getCTTc().getTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                tableCell.getCTTc().getTcPr().getVMerge().setVal(STMerge.RESTART);
            }
        }
    }

    public static void setVMMergContinue(XWPFTableCell xwpfTableCell){

        if(xwpfTableCell.getCTTc().getTcPr() == null){
            xwpfTableCell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
        }else{
            if(xwpfTableCell.getCTTc().getTcPr().getVMerge() == null){
                xwpfTableCell.getCTTc().getTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }else{
                xwpfTableCell.getCTTc().getTcPr().getVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

}
