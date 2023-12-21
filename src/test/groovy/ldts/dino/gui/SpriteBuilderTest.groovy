package ldts.dino.gui

import ldts.dino.utils.Colors
import spock.lang.Specification
import java.awt.image.BufferedImage

class SpriteBuilderTest extends Specification {

    SpriteBuilder spriteBuilder

    def setup() {
        spriteBuilder = new SpriteBuilder()
    }

    def "test loadImage"() {
        given:
        def filename = "coin"

        when:
        BufferedImage image = spriteBuilder.loadImage(filename)

        then:
        image != null
    }

    def "test loadText"() {
        given:
        def textDetails = new SpriteBuilder.TextDetails("test", 10, Colors.WHITE.getHex())

        when:
        BufferedImage image = spriteBuilder.loadText(textDetails)

        then:
        image != null
    }

    def "test isInCache"() {
        given:
        def filename = "coin"
        def image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB)

        expect:
        spriteBuilder.isInCache(filename) == false

        when:
        spriteBuilder.setToCache(filename, image)

        then:
        spriteBuilder.isInCache(filename) == true
    }

    def "test getFromCache"() {
        given:
        def filename = "coin"
        def image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB)
        spriteBuilder.setToCache(filename, image)

        expect:
        spriteBuilder.getFromCache(filename) == image
    }

    def "test setToCache"() {
        given:
        def filename = "coin"
        def image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB)

        when:
        spriteBuilder.setToCache(filename, image)

        then:
        spriteBuilder.getFromCache(filename) == image
    }

}