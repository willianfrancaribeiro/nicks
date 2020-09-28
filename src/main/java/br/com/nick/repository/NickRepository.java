package br.com.nick.repository;

import org.springframework.stereotype.Repository;

import br.com.nick.Nick;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface NickRepository extends CrudRepository<Nick,Long>{

}
