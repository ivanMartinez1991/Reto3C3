package co.usa.ivanm.reto3.Reto3C3.service;
import co.usa.ivanm.reto3.Reto3C3.model.Message;
import co.usa.ivanm.reto3.Reto3C3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int idMessage) {
        return messageRepository.getMessage(idMessage);

    }
    public Message save (Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else {
            Optional<Message> pMessage=messageRepository.getMessage(message.getIdMessage());
            if(!pMessage.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if (message.getIdMessage()!=null ){
            Optional<Message> pMessage = messageRepository.getMessage(message.getIdMessage());
            if(pMessage.isEmpty()){
                return messageRepository.save((message));
            }
        }
        return message;
    }
    public boolean deleteMessage(int id) {
        Boolean result = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return result;

    }

}
