/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.service.actor.ActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;
    
    @GetMapping("/actors")
    public List<Actor> getActorsList() {
        return (actorService.getAllActors());
    }

    @PostMapping("/actors")
    public void newActor(@RequestBody Actor actor) {
        actorService.save(actor);
    }

   @PutMapping("/actors")
    public void saveActor(@RequestBody Actor actor) {
        actorService.save(actor);
    }

    @GetMapping("actors/{actorId}")
    public Actor editActor(@PathVariable("actorId") Integer actorId) {
        return actorService.getActorById(actorId);
    }

}
