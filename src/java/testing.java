/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.search.grouping.GroupDocs;
import org.apache.lucene.search.grouping.GroupingSearch;
import org.apache.lucene.search.grouping.TopGroups;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

/**
 *
 * @author Administrator
 */
     
public class testing extends HttpServlet {
private static final String INDEX_DIR = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\sample\\data";
    
        int count=0,user_option,getposition=0,linenoo,flg=0,datacount=0;
        String logid,error,except,except1,info;
        String time1,time2,ut,choice,grop="0";  
        long unit;
        int grpcount=0,funcount=0;
        int position;
        
     
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        ArrayList items = new ArrayList();
        choice=request.getParameter("btn");
        Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));    
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        String exception=request.getParameter("exception");
        if(choice.equals("1"))
        {grop="0";  
            QueryParser qp = new QueryParser("logid", new StandardAnalyzer());
                            Query idquery = qp.parse(exception);  
                            TopDocs hits = searcher.search(idquery, 100000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
        if(choice.equals("2"))
        {grop="0";  
            exception="*"+exception+"*"; 
            Query query=new WildcardQuery(new Term("exception",exception));     
                            TopDocs hits = searcher.search(query, 100000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
        if(choice.equals("3"))
        {              grop="0";  
        QueryParser qp = new QueryParser("date", new StandardAnalyzer());
                            Query idquery = qp.parse(exception);
                           TopDocs hits = searcher.search(idquery, 1000000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
         if(choice.equals("4"))
        {         grop="0";  
                           exception="*"+exception+"*"; 
                            Query query=new WildcardQuery(new Term("error",exception));
                           TopDocs hits = searcher.search(query, 1000000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
           if(choice.equals("5"))
        {         grop="0";  
            time1=request.getParameter("time1");
            time2=request.getParameter("time2");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyhh:mm:ss");
                            Date date1 = dateFormat.parse(time1);
                            long unixtime1 = (long) date1.getTime()/1000; 
                             Date date2=dateFormat.parse(time2);
                            long unixtime2=(long)date2.getTime()/1000;
                            Query rangeQuery=LongPoint.newRangeQuery("time",unixtime1,unixtime2); 
                           TopDocs hits = searcher.search(rangeQuery, 1000000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
             if(choice.equals("6"))
        {         
                     grop="0";  
                     exception="*"+exception+"*"; 
                            Query query=new WildcardQuery(new Term("exception",exception));
                             time1=request.getParameter("time1");
            time2=request.getParameter("time2");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyhh:mm:ss");
                            Date date1 = dateFormat.parse(time1);
                            long unixtime1 = (long) date1.getTime()/1000; 
                             Date date2=dateFormat.parse(time2);
                            long unixtime2=(long)date2.getTime()/1000;
                            Query rangeQuery=LongPoint.newRangeQuery("time",unixtime1,unixtime2); 
                            BooleanQuery booleanQuery = new BooleanQuery.Builder().add(rangeQuery, BooleanClause.Occur.MUST).add(query, BooleanClause.Occur.MUST).build();
                           TopDocs hits = searcher.search(booleanQuery, 1000000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
          if(choice.equals("7"))
        {         grop="0";  
                          QueryParser qp = new QueryParser("logid", new StandardAnalyzer());
                            Query idquery = qp.parse(exception);
                             time1=request.getParameter("time1");
            time2=request.getParameter("time2");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyhh:mm:ss");
                            Date date1 = dateFormat.parse(time1);
                            long unixtime1 = (long) date1.getTime()/1000; 
                             Date date2=dateFormat.parse(time2);
                            long unixtime2=(long)date2.getTime()/1000;
                            Query rangeQuery=LongPoint.newRangeQuery("time",unixtime1,unixtime2); 
                            BooleanQuery booleanQuery = new BooleanQuery.Builder().add(rangeQuery, BooleanClause.Occur.MUST).add(idquery, BooleanClause.Occur.MUST).build();
                           TopDocs hits = searcher.search(booleanQuery, 1000000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
          if(choice.equals("8"))
        {         grop="0";  
                          QueryParser qp = new QueryParser("error", new StandardAnalyzer());
                            Query idquery = qp.parse(exception);
                             time1=request.getParameter("time1");
            time2=request.getParameter("time2");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyhh:mm:ss");
                            Date date1 = dateFormat.parse(time1);
                            long unixtime1 = (long) date1.getTime()/1000; 
                             Date date2=dateFormat.parse(time2);
                            long unixtime2=(long)date2.getTime()/1000;
                            Query rangeQuery=LongPoint.newRangeQuery("time",unixtime1,unixtime2); 
                            BooleanQuery booleanQuery = new BooleanQuery.Builder().add(rangeQuery, BooleanClause.Occur.MUST).add(idquery, BooleanClause.Occur.MUST).build();
                           TopDocs hits = searcher.search(booleanQuery, 1000000);
                             for (ScoreDoc sd : hits.scoreDocs)
             {
                            Document doc1 = searcher.doc(sd.doc);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add(doc1.get("date"));
                            items.add(java_date);
                            items.add(doc1.get("error"));
                            items.add(doc1.get("logid"));
                            items.add(doc1.get("exception"));
             }
                             request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
        
        
        
        if(choice.equals("9")){
        // System.out.println("received");
        grop="1";
        exception="*exception*";
        GroupingSearch groupingSearch = new GroupingSearch("exception");
                            groupingSearch.setGroupSort(Sort.RELEVANCE);
                            Query query=new WildcardQuery(new Term("exception",exception));
                            QueryParser qp = new QueryParser("error", new StandardAnalyzer());
                            Query query1 = qp.parse("syserr"); 
                            BooleanQuery booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST).add(query1, BooleanClause.Occur.MUST).build();
                            TopGroups<BytesRef> result = groupingSearch.search(searcher, booleanQuery, 0, 100);
                            GroupDocs<BytesRef>[] doc=result.groups;
             long [][] array=new long[result.totalGroupedHitCount][3];
             for (GroupDocs<BytesRef> group : doc) {
                            for (ScoreDoc scoredoc : group.scoreDocs) {
                                array[grpcount][0]=group.totalHits;
                                array[grpcount][1]=scoredoc.doc;
                                grpcount++;
                            }
                            }
             //System.out.println(grpcount);
            funcount=0;
         Arrays.sort(array, new Comparator<long[]>() {
    public int compare(long[] o1, long[] o2) {
        return Long.compare(o2[0], o1[0]);
    }});
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
             
                            
            while(true){
                            Document doc1=searcher.doc((int)array[funcount][1]);
                            unit=Long.valueOf(doc1.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
             items.add(doc1.get("date"));
             items.add(java_date);
             items.add(doc1.get("error"));
             items.add(doc1.get("logid"));
             items.add(doc1.get("exception"));
             items.add(array[funcount][0]);             
            funcount++;
           
            if(funcount==grpcount){grpcount=0;break;}
        }            
            request.setAttribute("data", items);
            request.setAttribute("group", grop);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);}
            
            
        }
        if(choice.equals("10"))
        {
            getposition=0;
            grop="0";
            except1="*"+exception+"*"; 
           Query query=new WildcardQuery(new Term("exception",except1)); 
           position=Integer.parseInt(request.getParameter("position"));
           //position=2;
          
           TopDocs end1 = searcher.search(query, 100000);
           //items.add("3");
            for (ScoreDoc sd : end1.scoreDocs)
        {                   
                            linenoo=sd.doc;
                            if(getposition==position)
                            {
                                while(true)
                                {                                                                   
                                    if(sd.doc>linenoo)
                                    {System.out.println("Sorry you cant go previous for this exception");break;
                                    }
                                    Document d = searcher.doc(linenoo);
                                    if(linenoo!=sd.doc){
                                    if(!d.get("error").contains("SYSERR"))
                                    {flg=1;break;}
                                    if(d.get("exception").toUpperCase().toLowerCase().contains("exception"))
                                    {flg=1;break;}}
                                    linenoo++;                                   
                            items.add(d.get("date"));
                            unit=Long.valueOf(d.get("time"));                            
                            Date date=new Date(unit*1000);
                            SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy");
                            String java_date = jdf.format(date);
                            items.add("["+java_date+"]");
                            items.add(d.get("error"));
                            items.add(d.get("logid"));
                            items.add(d.get("exception"));
                            //lineno++;
                            
                               
                            } 
                            }
                            getposition++;}
                            request.setAttribute("data", items);
                             request.setAttribute("group", grop);
                             RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/homepage.jsp");            
            dispatcher.forward(request, response);
        }
                                                         
                            
        
    } catch (Exception ex) {
        Logger.getLogger(testing.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
