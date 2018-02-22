package com.elsoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elsoproject.domain.Blogger;
import com.elsoproject.domain.Story;


@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {//ez a híd az adatbázis az adatbázis és a kód között itt a Storyk tudjanak áramlani
//a repo ha kiterjeszti a CrudRepository-t akkor képes vagy automatikusan menteniss
	
	List<Blogger>findAll(); //felülírjuk a findAll visszatérési értékét List-re
	
	Blogger findByName(String name);

}
