package com.github.nhojpatrick.cucumber.json.transformations.print.tests;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Plugin(name = "InMemoryAppender",
        category = Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE
)
public class InMemoryAppender
        extends AbstractAppender {

    private static final long serialVersionUID = 8047713135100613186L;

    private List<String> messages = new ArrayList<>();

    protected InMemoryAppender(String name,
                               Filter filter,
                               Layout<? extends Serializable> layout) {
        super(name, filter, layout, false, Property.EMPTY_ARRAY);
    }

    @Override
    public void append(final LogEvent event) {
        final String message = event.getMessage()
                .getFormattedMessage();
        getMessages()
                .add(message);
    }

    @PluginFactory
    public static InMemoryAppender createAppender(@PluginAttribute("name") String name,
                                                  @PluginElement("Layout") Layout<? extends Serializable> layout,
                                                  @PluginElement("Filter") final Filter filter,
                                                  @PluginAttribute("otherAttribute") String otherAttribute) {
        if (name == null) {
            name = "InMemoryAppender";
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new InMemoryAppender(name, filter, layout);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}
