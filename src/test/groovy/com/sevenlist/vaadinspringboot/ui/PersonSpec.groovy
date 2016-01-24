package com.sevenlist.vaadinspringboot.ui

import geb.spock.GebSpec

class PersonSpec extends GebSpec {

    def "displays the found person when the Search button is clicked"() {
        given:
        go 'http://localhost:8080'

        when:
        $('div.v-button').click()

        then:
        $('div.v-label').text() == 'Found: [Person(id:1, firstName:Seven, lastName:List)]'
    }
}
