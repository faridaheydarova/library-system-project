package az.developia.librarysystemfarida.config;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@Component
public class MySession {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

