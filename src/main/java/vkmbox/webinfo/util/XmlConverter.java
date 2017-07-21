package vkmbox.webinfo.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;

public class XmlConverter {
  public static XMLGregorianCalendar getXMLGregorianCalendar(LocalDate date) throws DatatypeConfigurationException {
    GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
    return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
  }
}