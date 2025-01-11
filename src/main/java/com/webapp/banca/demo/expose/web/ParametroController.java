package com.webapp.banca.demo.expose.web;


import com.webapp.banca.demo.business.ParameterService;
import com.webapp.banca.demo.model.domain.Parameter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank/")
@Slf4j
public class ParametroController {

    private static final Logger logger = LoggerFactory.getLogger(ParametroController.class);

    @Autowired
    private ParameterService parameterService;

    @GetMapping(value = "parameter/{parameterId}",
            produces = {"application/json"})
    public Maybe<Parameter> getParameter(@PathVariable String clientId) {
        logger.info("Processing request for /api/bank/parameter/{parameterId}");
        return this.parameterService.findById(clientId);
    }

    @GetMapping(value = "parameters",
            produces = {"application/json"})
    public Flowable<Parameter> getParameters() {
        logger.info("Procesando la solicitud para /api/bank/parameters");
        return this.parameterService.findAll();
    }

    @PostMapping(value = "parameter",
            produces = {"application/json"})
    public Maybe<Parameter> postParameter(@RequestBody Parameter parameter) {
        logger.info("Procesando la solicitud para /api/bank/parameter");
        return this.parameterService.insert(parameter);
    }

}
