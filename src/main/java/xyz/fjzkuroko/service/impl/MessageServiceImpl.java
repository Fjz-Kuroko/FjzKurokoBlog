package xyz.fjzkuroko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fjzkuroko.dao.MessageDao;
import xyz.fjzkuroko.entity.Message;
import xyz.fjzkuroko.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public int addMessage(Message message) {
        return messageDao.addMessage(message);
    }
}
