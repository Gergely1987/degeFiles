package com.elsoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elsoproject.domain.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {//ez a híd az adatbázis az adatbázis és a kód között itt a Storyk tudjanak áramlani
//select * from story
	List<Story>findAll(); //felülírjuk a findAll visszatérési értékét List-re
	
	//select * from story where posted in (select max(posted) from story)limit 1;
	Story findFirstByOrderByPostedDesc();

	//KÜLÖNBŐZŐKÉPPEN ÍRHATOM MEG UGYANAZT A LEKÉRDEZÉST!!!!!!!!!!!! :
	
//	Story findByTitle(String title);
	
	//@Query(value="select * from story where title=?1 limit 1", nativeQuery=true) //így adunk át sima sql-t
//	Story findByTitle(String title);
	
//	@Query(value="select * from story where title=:title limit 1", nativeQuery=true) //így adunk át sima sql-t
//	Story findByTitle(@Param("title")String title);
	
	@Query(value= "select s from Story s where s.title= :title") //így adunk át sima sql-t
	Story findByTitle(@Param("title") String title);

	
	
	
	List<Story>findAllByBloggerNameIgnoreCaseOrderByPostedDesc(String name);
	
	
}
