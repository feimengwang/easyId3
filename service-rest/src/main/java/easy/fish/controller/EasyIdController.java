package easy.fish.controller;

import easy.fish.intf.IdServiceIntf;
import easy.fish.vo.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Java猿
 */
@RestController
@RequestMapping("/id")
public class EasyIdController {
    @Autowired
    private IdServiceIntf idService;

    @GetMapping("/genId")
    public long genId() {
        return idService.genId();
    }

    @GetMapping("/makeId")
    public Id makeId(long time){
        return idService.makeId(time);
    }
}
