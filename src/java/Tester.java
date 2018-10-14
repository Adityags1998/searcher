/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
 
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
public class Tester {
private static final String INDEX_DIR = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\sample\\data";
    public static void main(String[] args) throws IOException, ParseException {
        IndexWriter writer = createWriter();
        List<Document> documents = new ArrayList<>();
        int ptr;
        int[] end = new int[7];
        String str;
        FileInputStream fstream=new FileInputStream("example.txt");
        BufferedReader br=new BufferedReader(new InputStreamReader(fstream));
         while((str=br.readLine())!=null)
         {
             ptr=0;
             for(int i=0;i<str.length();i++)
             {
                 if(str.charAt(i)==':'&&ptr==4)
                 {
                     end[ptr]=i;
                     ptr++;
                 }
                 if(str.charAt(i)=='|'){
                 end[ptr]=i;
                 ptr++;
              }}
             String dateString = str.substring(end[0]+2,end[1]-1)+" "+str.substring(1,end[0]-5);
             DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date date = dateFormat.parse(dateString);
            long unixTime = (long) date.getTime()/1000;
            //System.out.println(str.substring(0,end[0])+" "+unixTime+" "+str.substring(end[1]+1,end[2])+" "+str.substring(end[2]+1,end[3])+" "+str.substring(end[3]+1,end[4])+" "+str.substring(end[4]+1, end[5]));
            Document document=createDocument(str.substring(0,end[0]),unixTime,str.substring(end[1]+1,end[2]),str.substring(end[2]+1,end[3]),str.substring(end[3]+1,end[4]),str.substring(end[4]+1, end[5]));
            
            documents.add(document);
         }
        writer.deleteAll();         
        writer.addDocuments(documents);
        writer.commit();
        writer.close();
    }
   private static Document createDocument  (String date, Long time, String error,String info,String logid,String exception)
    {
        Document document = new Document();
        document.add(new TextField("date", date , Field.Store.YES));
        document.add(new LongPoint("time", time));
        document.add(new StoredField("time",time));
        document.add(new TextField("error", error , Field.Store.YES));
        document.add(new TextField("info", info , Field.Store.YES));
        document.add(new TextField("logid", logid , Field.Store.YES));
        document.add(new TextField("exception", exception , Field.Store.YES));
       //  document.add(new SortedDocValuesField("time", new BytesRef(time)));
       document.add(new NumericDocValuesField("time",time));
         document.add(new SortedDocValuesField("exception", new BytesRef(exception)));
        document.add(new SortedDocValuesField("logid", new BytesRef(logid)));
        return document;
    }
 
    private static IndexWriter createWriter() throws IOException
    {
        FSDirectory dir = FSDirectory.open(Paths.get(INDEX_DIR));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(dir, config);
        return writer;
    }  
}

