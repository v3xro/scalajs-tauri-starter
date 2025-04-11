# `scalajs-tauri-starter`

A tiny [tauri] application template using [scalajs] and [laminar] frontend library. Built with ❤️ by [mill]

## Running

Install [mill] and [tauri] (using the `cargo` method e.g. `cargo install tauri`)

Then:

* `npm install` (required currently because the scalablytyped plugin does not grab node_modules by itself)
* `mill -w frontend.devBundleTauri` (to compile the frontend and watch the scala files for changes)
* `cargo tauri dev` (to run the tauri desktop app)

## Why?

To build apps for mobile platforms, without needing to go too platform-specific, and without touching 
Typescript/Javascript. [laminar] and [scalajs] in particular are perfectly suited for complex frontend logic, and [tauri]
provides the local "backend" to do anything non-UI related and gives the ability to integrate with platform-specific 
features. Also trying out [mill] as a lighter and faster alternative build tool for the Scala code.

## TODO

On the build side:

- [ ] Integrate a CSS bundler e.g. [lightningcss]
- [ ] Split the scalablytyped definition away from the main build (seems to be more difficult to do in mill 0.12?)
- [ ] Get the scalablytyped plugin to call npm by itself to get the node_modules (much like the rollup bundler plugin does)
- [ ] Investigate whether it's possible to use rolldown as a replacement for rollup for bundling

[laminar]: https://laminar.dev
[lightningcss]: https://lightningcss.dev
[mill]: https://mill-build.org/
[scalajs]: https://www.scala-js.org/
[tauri]: https://tauri.app/
