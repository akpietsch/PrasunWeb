package dh.master.info.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.print.Doc;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dh.master.info.model.Work;


@ContextConfiguration
@Transactional
public class WorkRepositoryTest {

	@Autowired
	WorkRepository repository;

	@Test
	public void insertTest() {
		final String author="Georg Budruss";
		final String introduction="this is the introduction";
		Work work=new Work();
		work.setAuthor(author);
		work.setIntroduction(introduction);
		
		repository.save(work);
		
		Work dbDoc=repository.findOne(work.getId());
		assertNotNull(dbDoc);
		assertEquals(author, dbDoc.getAuthor());
		assertEquals(introduction, dbDoc.getIntroduction());
		
	}

}
