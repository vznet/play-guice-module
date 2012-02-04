package play.modules.guice;

import play.Play;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.inject.Stage;

public abstract class PlayAbstractModule extends AbstractModule {

	private boolean lazySingletonScopeBinded = false;
		
	protected <T> void bindLazySingletonOnDev(Class<T> expected, Class<? extends T> implClass){
		if(!lazySingletonScopeBinded){
			bindScope(LazySingleton.class, MoreScopes.LAZY_SINGLETON);
			lazySingletonScopeBinded = true;
		}
		
		if(Play.mode.isDev()){
            bind(implClass).in(MoreScopes.LAZY_SINGLETON);
			Provider<T> provider = LazyBinder.newLazyProvider(expected, implClass);
			bind(expected).toProvider(provider);
		}else{
			bind(expected).to(implClass).in(Scopes.SINGLETON);
		}
	}
	
}
