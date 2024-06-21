// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "HarshallcodeTamperProtection",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "HarshallcodeTamperProtection",
            targets: ["tamperProtectionPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "tamperProtectionPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/tamperProtectionPlugin"),
        .testTarget(
            name: "tamperProtectionPluginTests",
            dependencies: ["tamperProtectionPlugin"],
            path: "ios/Tests/tamperProtectionPluginTests")
    ]
)