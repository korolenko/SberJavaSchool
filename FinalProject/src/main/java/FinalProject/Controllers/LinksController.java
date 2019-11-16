package FinalProject.Controllers;

import FinalProject.Entities.LinksEntity;
import FinalProject.Services.LinksService;
import FinalProject.dto.LinksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinksController {

    @Autowired
    private LinksService linksService;

    @GetMapping("/{id}")
    @ResponseBody
    public LinksEntity get(@PathVariable Long id) {
        return linksService.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public LinksEntity create(@RequestBody LinksDto linksDto) {
        return linksService.create(linksDto);
    }

    @PutMapping("")
    @ResponseBody
    public LinksEntity update(@RequestBody LinksDto linksDto){
        return linksService.update(linksDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        linksService.delete(id);
    }

}
