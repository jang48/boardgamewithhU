package project.thirdproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
//public class ChatServiceImpl implements  ChatService{
public class ChatServiceImpl{
    @Autowired
    private ChatDao chatDao;
//    @Override
//    public Map<String, Object> doAdd(Map<String, Object> param){
//        chatDao.add(param);
//        Random random = new Random();
//        int id =  random.nextInt(1000000);
//        param.put("id", id);
//        Map<String, Object> rs = new HashMap<>();
//        rs.put("resultCode", "s-1");
//        rs.put("msg", "채팅방이 생성되었습니다.");
//        rs.put("id", param.get("id"));
//        return rs;
//    }
//
//    @Override
//    public List<Chatroom> getList() {
//
//        return chatDao.getList();
//    }
}
