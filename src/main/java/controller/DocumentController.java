package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Document;
import hsqlServer.CreateAndPopulateDB;
import service.DocumentService;

@RestController
public class DocumentController {
	@Autowired
	DocumentService DocumentService;
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllDocuments",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Document>getDocuments() throws Exception{
		
		CreateAndPopulateDB capDB = new CreateAndPopulateDB();
		CreateAndPopulateDB.checkOrCreateTable(capDB);
		List<Document> listOfDocuments = DocumentService.getAllDocuments();
		return listOfDocuments;
	}
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value = "/getDocument/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Document getDocumentById(@PathVariable int id) {  
	  return DocumentService.getDocument(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/addDocument", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addDocument(@RequestBody Document Document) {  
	  DocumentService.addDocument(Document);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/updateDocument", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateDocument(@RequestBody Document Document) {  
	  DocumentService.updateDocument(Document);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/deleteDocument/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteDocument(@PathVariable("id") int id) {  
	  DocumentService.deleteDocument(id);    
	 } 
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/documentsExpiratingIn/{days}")
	public List<Document> getDocumentsExpiratingIn(@PathVariable("days") int days) {
		return DocumentService.getDocumentsExpiratingIn(days);
	}
}
