package br.com.orbetail.gettrainee.model.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author heitor
 * @since 05/05/16.
 */
public enum Role implements GrantedAuthority {
    ROLE_PUBLIC {
        @Override
        public String getAuthority() {
            return "ROLE_PUBLIC";
        }
    },
    ROLE_UNIVERSIDADE {
        @Override
        public String getAuthority() {
            return "ROLE_UNIVERSIDADE";
        }
    },
    ROLE_EMPRESA {
        @Override
        public String getAuthority() {
            return "ROLE_EMPRESA";
        }
    },
    ROLE_ALUNO {
        @Override
        public String getAuthority() {
            return "ROLE_ALUNO";
        }
    }
}
