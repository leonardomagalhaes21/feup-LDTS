package ldts.dino.utils

import ldts.dino.utils.SoundManager
import spock.lang.Specification

class SoundManagerTest extends Specification {

    def "test getInstance"() {
        given :
        def instance1 = SoundManager.getInstance()
        def instance2 = SoundManager.getInstance()

        expect:
        instance1 == instance2
    }

    def "test constructor"() {
        given:
        def soundManager = SoundManager.getInstance()

        expect:
        soundManager != null
        soundManager.gameMusic != null
        soundManager.bombSound != null
        soundManager.crouchSound != null
        soundManager.gameOverSound != null
        soundManager.jumpSound != null
        soundManager.menuSelectionSound != null
        soundManager.pickSound != null
    }

    def "test MusicVolume"() {
        when:
        SoundManager.getInstance().setMusicVolume(0.8F)

        then:
        SoundManager.getInstance().getMusicVolume() == 0.8F
    }
}