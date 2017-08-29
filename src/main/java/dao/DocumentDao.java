package dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Car;
import bean.Document;

@Repository
@Transactional
public class DocumentDao {
	
	 @Autowired  
	 private SessionFactory sessionFactory;  
	  
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }  

	 public List<Document> getAllDocuments() {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  List<Document> DocumentList = session.createQuery("from Document").list();  
		  getAllSublists(DocumentList);
		  return DocumentList;  
		 }  
	 
	 public List<Document>getAllSublists(List<Document> doc){
		 for (Document d:doc) {
			  System.out.println(d.getCar());
			  System.out.println(d.getStatus());
		  }
		 return doc;
	 }
		 	 
	 public Document getDocument(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  Document Document = (Document) session.get(Document.class, new Integer(id)); 
		  return Document;  
		 }  
		  
	 public Document addDocument(Document Document) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  Document.setId(GeneralQuerrys.maxIdFromTable("select max(documents.id) from Document documents",session)); 
		  System.out.println(Document.toString());
		  session.merge(Document);  
		  return Document;  
		 }  
		  
	 public void updateDocument(Document Document) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  session.update(Document);  
		 }  
		  
	 public void deleteDocument(int id) {  
		 
		  Session session = this.sessionFactory.getCurrentSession();  
		  Document p = (Document) session.load(Document.class, new Integer(id));  
		  
		  if (null != p) {  
		   session.delete(p);  
		  }  
		 }

	public List<Document> getDocumentsExpiratingIn(int days) {
		Session s = this.sessionFactory.getCurrentSession();
		Calendar cDate = Calendar.getInstance();
		cDate.add(Calendar.DATE, days);
		Query q = s.createQuery("from Document d join fetch d.status s where d.expirationDate <=:cDate and s.progress=:status");
		q.setParameter("status", "in status");
		q.setParameter("cDate", cDate);
		List<Document> lD=q.list();
		getAllSublists(lD);
		return lD;
	}   
}	