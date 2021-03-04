package xyz.fjzkuroko.service;

import xyz.fjzkuroko.vo.ViewLabels;

import java.util.List;

public interface LabelsService {
    String getLabelByLid(int lid);
    List<ViewLabels> getAllLabelsAndArticleNum();
}
