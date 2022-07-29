## Description

Contains the best sample usage of the anvil library

## Modules implementation

`timer-without-component-module` - implements DI using @Module. The annotated di-module must contain 
all the dependencies exposed by the library-module.  
The module uses `anvil { generateDaggerFactories = true }` inside gradle configuration.
And doesn't use any dagger components, so it compiles faster than `locale-with-component-module`

`locale-with-component-module` - implements DI using dagger component. The library-module can use
any of anvil shortcuts (e.g. `@ContributesBinding`). The module uses dagger with `kapt`, so it compiles
slover
