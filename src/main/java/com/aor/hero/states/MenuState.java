package com.aor.hero.states;

import com.aor.hero.controller.Controller;
import com.aor.hero.controller.menu.MenuController;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.viewer.Viewer;
import com.aor.hero.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
