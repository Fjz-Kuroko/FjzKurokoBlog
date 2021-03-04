package xyz.fjzkuroko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fjzkuroko.dao.LabelsDao;
import xyz.fjzkuroko.service.LabelsService;
import xyz.fjzkuroko.vo.ViewLabels;

import java.util.List;

@Service("labelsService")
public class LabelsServiceImpl implements LabelsService {

    @Autowired
    private LabelsDao labelsDao;

    @Override
    public String getLabelByLid(int lid) {
        return labelsDao.getLabelByLid(lid);
    }

    @Override
    public List<ViewLabels> getAllLabelsAndArticleNum() {
        return labelsDao.getAllLabelsAndArticleNum();
    }
}
