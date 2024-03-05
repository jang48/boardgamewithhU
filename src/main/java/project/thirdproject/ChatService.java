package project.thirdproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ChatService {
    public Map<String, Object> doAdd(Map<String, Object> param);
}
