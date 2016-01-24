package com.sevenlist.vaadinspringboot.ui

import com.sevenlist.vaadinspringboot.repository.PersonRepository
import com.vaadin.annotations.Theme
import com.vaadin.event.ShortcutAction
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.Component
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.Layout
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme
import org.springframework.beans.factory.annotation.Autowired

@Theme("valo")
@SpringUI
class PersonUI extends UI {

    private TextField firstNameTextField
    private Label personFoundLabel

    @Autowired
    private PersonRepository personRepository

    @Override
    protected void init(VaadinRequest request) {
        content = createContentLayout()
    }

    private Layout createContentLayout() {
        Layout contentLayout = new VerticalLayout()
        contentLayout.margin = true
        contentLayout.spacing = true
        contentLayout.addComponent(createSearchLayout())
        contentLayout.addComponent(createPersonFoundLabel())
        contentLayout
    }

    private Layout createSearchLayout() {
        Layout searchLayout = new HorizontalLayout()
        searchLayout.margin = true
        searchLayout.spacing = true
        searchLayout.addComponent(createFirstNameTextField())
        searchLayout.addComponent(createSearchByFirstNameButton())
        searchLayout
    }

    private Component createFirstNameTextField() {
        firstNameTextField = new TextField()
        firstNameTextField.value = 'Seven'
        firstNameTextField
    }

    private Component createSearchByFirstNameButton() {
        Button searchButton = new Button("Search")
        searchButton.addClickListener({
            personFoundLabel.value = "Found: ${personRepository.findByFirstName(firstNameTextField.value)}"
        })
        searchButton.addStyleName(ValoTheme.BUTTON_PRIMARY)
        searchButton.setClickShortcut(ShortcutAction.KeyCode.ENTER)
        searchButton
    }

    private Component createPersonFoundLabel() {
        personFoundLabel = new Label()
        personFoundLabel
    }
}
