package play.modules.guice;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import com.google.inject.Injector;
import com.google.inject.ScopeAnnotation;

/**
 * https://github.com/wiregit/wirecode/blob/master/components/common/src/main/java/org/limewire/inject/
 * 
 * Apply this to implementation classes when you want only one instance
 * (per {@link Injector}) to be reused for all injections for that binding.
 * 
 * The singleton is guaranteed to be constructed lazily.
 */
@Target( { TYPE, METHOD })
@Retention(RUNTIME)
@ScopeAnnotation
public @interface LazySingleton {

}
