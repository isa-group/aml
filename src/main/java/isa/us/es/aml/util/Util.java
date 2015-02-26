package isa.us.es.aml.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Util {

    public Util() {
    }

    private static final Logger LOG = Logger.getLogger(Util.class.getName());

    public static String withoutDoubleQuotes(String s) {
        String str = s;
        if (str.startsWith("\"")) {
            str = str.substring(1, str.length());
        }
        if (str.endsWith("\"")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String withoutQuotes(String s) {
        String str = s;
        if (str.startsWith("\'")) {
            str = str.substring(1, str.length());
        }
        if (str.endsWith("\'")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String encodeEntities(String s) {
        String str = s;
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        return str;
    }

    public static String decodeEntities(String s) {
        String str = s;
        str = str.replaceAll("&lt;", "<");
        str = str.replaceAll("&gt;", ">");
        return str;
    }

    public static String convertMetricType(String originalType) {
        String newType = null;

        if (originalType != null) {
            originalType = originalType.toLowerCase();

            if (originalType.equals("float")
                    || originalType.equals("double")
                    || originalType.equals("natural")
                    || originalType.equals("number")
                    || originalType.equals("cost")
                    || originalType.equals("time")
                    || originalType.equals("size")
                    || originalType.equals("errors")
                    || originalType.equals("money")
                    || originalType.equals("percent")
                    || originalType.equals("integer")
                    || originalType.equals("string")) {
                newType = "integer";
            } else {
                newType = "enumerated";
            }
        }

        return newType;
    }

    public static String loadFile(String filePath) {
        // Location of file to read
        File f = new File(filePath);
        FileInputStream is;
        String res = "";
        try {
            is = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line.replaceAll("	", "\t")).append("\n");
            }
            res = sb.toString();
            is.close();
        } catch (FileNotFoundException e) {
            LOG.log(Level.WARNING, "loadFile error", e);

        } catch (IOException e) {
            LOG.log(Level.WARNING, "loadFile error", e);
        }
        return res;
    }

    public static String DOM2String(Document doc) {
        String xmlString = null;
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //set some options on the transformer
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            //initialize StreamResult with File object to save to file
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            xmlString = result.getWriter().toString();
        } catch (TransformerConfigurationException e) {
            LOG.log(Level.WARNING, "DOM2String error", e);
        } catch (IllegalArgumentException | TransformerFactoryConfigurationError | TransformerException e) {
            LOG.log(Level.WARNING, "DOM2String error", e);
        }

        return xmlString;
    }

    public static String getTimestamp() {
        String timestamp;
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        timestamp = sdf.format(now);
        return timestamp;
    }

    public static String dateTrasform(Date date) {
        String result;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        result = sdf.format(date);
        return result;
    }

    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            LOG.log(Level.WARNING, "getStringFromInputStream error", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOG.log(Level.WARNING, "getStringFromInputStream error", e);
                }
            }
        }

        return sb.toString();

    }
}
