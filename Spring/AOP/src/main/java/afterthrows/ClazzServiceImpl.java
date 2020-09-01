package afterthrows;

public class ClazzServiceImpl implements ClazzService{

    @Override
    public void save(String name) {
        System.out.println("service调用" + name);
    }
}
