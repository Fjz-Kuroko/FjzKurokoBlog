package xyz.fjzkuroko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fjzkuroko.dao.SayingsDao;
import xyz.fjzkuroko.entity.Sayings;
import xyz.fjzkuroko.service.SayingsService;

import java.util.List;

@Service("sayingsService")
public class SayingsServiceImpl implements SayingsService {

    @Autowired
    private SayingsDao sayingsDao;

    @Override
    public List<Sayings> getAllSayings() {
        return sayingsDao.getAllSayings();
    }
}
