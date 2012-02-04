package play.modules.guice;

import play.Play;

import com.google.inject.Injector;
import com.google.inject.Stage;
 
/**
  * Implemented if a custom injector is desired
  */
public abstract class GuiceSupport{
	
	protected Stage stage = Play.mode.isDev() ? Stage.DEVELOPMENT : Stage.PRODUCTION;
	
	protected abstract Injector configure();
}
