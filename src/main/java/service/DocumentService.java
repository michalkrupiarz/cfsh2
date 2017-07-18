package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Document;
import dao.DocumentDao;

@Service("DocumentService")
@Transactional
public class DocumentService {
	@Autowired
	DocumentDao DocumentDao;
	
	@Transactional
	public List<Document> getAllDocuments() {
		return DocumentDao.getAllDocuments();
	}
	@Transactional
	public Document getDocument(int id) {
		return DocumentDao.getDocument(id);
	}
	@Transactional
	public void addDocument(Document Document) {
		DocumentDao.addDocument(Document);
		
	}
	@Transactional
	public void updateDocument(Document Document) {
		DocumentDao.updateDocument(Document);
		
	}

	public void deleteDocument(int id) {
		DocumentDao.deleteDocument(id);		
	}
	
}