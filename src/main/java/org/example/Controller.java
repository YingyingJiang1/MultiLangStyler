package org.example;

import org.dom4j.DocumentException;
import org.example.myException.EAsourceUnsetException;
import org.example.myException.ParserRuleContextTypeException;
import org.example.style.ProgramStyle;
import org.example.styler.Applicator;
import org.example.styler.Extractor;
import org.example.styler.XmlExtractor;
import org.example.styler.AntlrStyler;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/3/13 20:59
 */
public class Controller {
  // For test
  public static ProgramStyle programStyle;

  public static void execute(Configuration conf) {
    if (conf.extractionCollection.isEmpty() || conf.applicationCollection.isEmpty()) {
      System.out.println("No extraction or application files.");
      return;
    }

    try {
      ProgramStyle programStyle = new ProgramStyle();
      Controller.programStyle = programStyle;
      Extractor extractor = createExtractor(conf, programStyle);
      List<Applicator> applicators = new ArrayList<>();
      applicators.add(new AntlrStyler(conf, programStyle));

      extractor.extractStyle();
//      if(!programStyle.isRulesEnough()) {
//        System.err.println("File is so short, please change file!");
//        return;
//      }

//        extractor.writeStyleInXml(conf.styleFileSavedDir);

      for(Applicator applicator : applicators) {
        applicator.applyStyle();
      }
    } catch (EAsourceUnsetException | IOException | ParserRuleContextTypeException |
             DocumentException e) {
      System.err.printf("Failed to write file:" + e.getMessage());
    }
  }

  private static Extractor createExtractor(Configuration conf, ProgramStyle programStyle) throws IOException {
    Extractor extractor = null;
    if(conf.useExistedStyle) {
      boolean hasExistedStyle = Arrays.stream(new File(conf.styleFileSavedDir).listFiles()).toList()
          .contains(new File(conf.getStyleFile()));
      if (hasExistedStyle) {
        extractor = new XmlExtractor(conf, programStyle);
      }
    }
    if (extractor == null) {
      extractor = new AntlrStyler(conf, programStyle);
    }
    return extractor;
  }
}
