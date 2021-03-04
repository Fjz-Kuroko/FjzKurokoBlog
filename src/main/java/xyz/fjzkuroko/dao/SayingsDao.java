package xyz.fjzkuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.fjzkuroko.entity.Sayings;

import java.util.List;

@Repository
@Mapper
public interface SayingsDao {
    List<Sayings> getAllSayings();
}
