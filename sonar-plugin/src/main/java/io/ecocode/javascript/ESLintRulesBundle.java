package io.ecocode.javascript;

import org.sonar.plugins.javascript.api.RulesBundle;

public class ESLintRulesBundle implements RulesBundle {

    @Override
    public String bundlePath() {
        return "/ecocode-eslint-plugin.tgz";
    }

}
