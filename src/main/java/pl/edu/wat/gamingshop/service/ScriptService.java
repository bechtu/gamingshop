package pl.edu.wat.gamingshop.service;

import lombok.extern.slf4j.Slf4j;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.gamingshop.repository.EmployeeRepository;
import pl.edu.wat.gamingshop.repository.ProductsRepository;


@Service
@Slf4j
public class ScriptService {
    private final ProductsRepository productsRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ScriptService(EmployeeRepository employeeRepository,
                         ProductsRepository productsRepository) {
        this.employeeRepository = employeeRepository;
        this.productsRepository = productsRepository;
    }

    public String exec(String script){
        try (Context context = Context.newBuilder("js")
                .allowAllAccess(true)
                .build()){
            var bindings = context.getBindings("js");
            bindings.putMember("employeeRepository", employeeRepository);
            bindings.putMember("productsRepository", productsRepository);
            return context.eval("js", script).toString();
        } catch (PolyglotException e) {
            log.error("Error executing", e);
            return e.getMessage() + "\n" + e.getSourceLocation().toString();
        }
    }



}