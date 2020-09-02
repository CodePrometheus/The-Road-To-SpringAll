package aop;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {


    @Override
    public void save(String name) {
        System.out.println("处理业务调用save DAO" + name);
    }

    @Override
    public String find(String name) {
        System.out.println("处理业务调用find DAO" + name);
        return name;
    }
}
