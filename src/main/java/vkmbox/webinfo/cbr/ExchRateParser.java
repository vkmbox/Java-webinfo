package vkmbox.webinfo.cbr;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.cbr.web.EnumValutesXMLResponse.EnumValutesXMLResult;

import java.util.List;
import java.util.ArrayList;

public class ExchRateParser {
  public static class Currency {
    String vCode; //Внутренний код валюты*
    String vName; // - Название валюты
    String vEngname; // - Англ. название валюты
    int vNom; // - Номинал
    String vCommonCode; // - Внутренний код валюты, являющейся 'базовой'**
    short vNumCode; // - цифровой код ISO
    String vCharCode; // - 3х буквенный код ISO
    
    public Currency() {}
    
    public Currency( String vCode, String vName, String vEngname, int vNom
                   , String vCommonCode, short vNumCode, String vCharCode ) 
    {
      this.vCode = vCode;
      this.vName = vName;
      this.vEngname = vEngname;
      this.vNom = vNom;
      this.vCommonCode = vCommonCode;
      this.vNumCode = vNumCode;
      this.vCharCode = vCharCode;
    }
    
    @Override
    public String toString() {
      StringBuilder result  = new StringBuilder("Code=").append(vCode).append(";Name=").append(vName)
        .append(";Engname=").append(vEngname).append(";Nom=").append(vNom)
        .append(";CommonCode=").append(vCommonCode).append(";NumCode").append(vNumCode)
        .append(";CharCode=").append(vCharCode);
      return result.toString();
    }
  }
    
  public static List<Currency> parseEnumValutes(EnumValutesXMLResult xmlResult) {
    Node element = (Node)xmlResult.getContent().get(0);
    NodeList currList = element.getChildNodes();
    List<Currency> result = new ArrayList<>();
    for ( int ii = 0; ii < currList.getLength(); ii++ ) 
    {
      element = currList.item(ii);
      NodeList attrList = element.getChildNodes();
      Currency curr = new Currency();
      for ( int jj = 0; jj < attrList.getLength(); jj++ ) 
      {
        Node currentNode = attrList.item(jj);
        String name = currentNode.getNodeName();
        String value = currentNode.getFirstChild().getNodeValue();
        switch ( name ) {
          case "Vcode":
            curr.vCode = value.trim(); break;
          case "Vname":
            curr.vName = value.trim(); break;
          case "VEngname":
            curr.vEngname = value.trim(); break;
          case "Vnom":
            curr.vNom = Integer.parseInt(value); break;
          case "VcommonCode":
            curr.vCommonCode = value.trim(); break;
          case "VnumCode":
            curr.vNumCode = Short.parseShort(value); break;
          case "VcharCode":
            curr.vCharCode = value.trim(); break;
        }
      }
      System.out.println(curr.toString());
      result.add(curr);
    }; // while ( (element = element.getPreviousSibling()) != null );
    return result;
  }
}