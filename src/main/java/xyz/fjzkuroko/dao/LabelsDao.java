package xyz.fjzkuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.fjzkuroko.vo.ViewLabels;

import java.util.List;

@Repository
@Mapper
public interface LabelsDao {
    String getLabelByLid(int lid);
    List<ViewLabels> getAllLabelsAndArticleNum();
}
