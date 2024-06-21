import Foundation

@objc public class tamperProtection: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
